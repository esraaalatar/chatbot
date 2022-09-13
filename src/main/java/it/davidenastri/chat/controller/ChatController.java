package it.davidenastri.chat.controller;

import it.davidenastri.chat.model.ChatForm;
import it.davidenastri.chat.model.Intent;
import it.davidenastri.chat.model.IntentMessage;
import it.davidenastri.chat.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        if (this.messageService.getChatMessages().size() > 0) {
            int msgId = this.messageService.getMessagesId(chatForm.getMessageText());
            model.addAttribute("chatReplies", this.messageService.getChatReplies(msgId));
        }
        return "chat";
    }

    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model, Principal principal) {
        chatForm.setUsername(principal.getName());
        this.messageService.addMessage(chatForm);
        this.messageService.getChatReplies(this.messageService.getMessagesId(chatForm.getMessageText()));
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        model.addAttribute("chatReplies", this.messageService.getChatReplies(this.messageService.getMessagesId(chatForm.getMessageText())));

        return "redirect:/chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[]{"Say", "Shout", "Whisper"};
    }

}
