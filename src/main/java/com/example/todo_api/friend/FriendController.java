package com.example.todo_api.friend;

import com.example.todo_api.friend.dto.FriendAccept;
import com.example.todo_api.friend.dto.FriendRequest;
import com.example.todo_api.todo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {
    private final FriendService friendService;
    @PostMapping
    public ResponseEntity<Void> requestFriend(@RequestBody FriendRequest request) throws Exception {
        Friend friend = friendService.requestFriend(request.getMemberId1(), request.getMemberId2());
        return ResponseEntity.created(URI.create("/friend/"+ friend.getId())).build();
    }
    @PatchMapping
    public ResponseEntity<Void> acceptFriend(@RequestBody FriendAccept accept) throws Exception {
        friendService.acceptFriend(accept.getMemberId1(), accept.getMemberId2());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/list")
    public ResponseEntity<List<Friend>> getFriend(@RequestBody Long memberId) throws Exception {
        List<Friend> member = friendService.viewFriend(memberId);
        return ResponseEntity.ok().body(member);
    }
    @DeleteMapping ("/{friend}")
    public ResponseEntity<Void> deleteFriend(@PathVariable Friend friend) throws Exception {
        friendService.deleteFriend(friend);
        return ResponseEntity.noContent().build();
    }
    @GetMapping ("/{memberId}")
    public ResponseEntity<List<Todo>> getTodoList(@RequestBody Long memberId) throws Exception {
        List<Todo> todoList = friendService.viewFreindTodo( memberId);
        return ResponseEntity.ok().body(todoList);
    }
}
