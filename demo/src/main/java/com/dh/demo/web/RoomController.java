package com.dh.demo.web;

import com.dh.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alan on 10/06/2017.
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RoomRequestDTO> getAllRooms(){
        return roomService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewRoom(@RequestBody RoomController.RoomRequestDTO room){
        roomService.addNewRoom(room);
    }

    public static class RoomRequestDTO{
        private String code;
        private String capacity;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
        }
    }
}
