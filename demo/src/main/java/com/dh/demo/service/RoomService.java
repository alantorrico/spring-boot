package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.web.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 10/06/2017.
 */
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomController.RoomRequestDTO> getAll(){
        List<RoomController.RoomRequestDTO> results = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();

        for (Room room: rooms) {
            RoomController.RoomRequestDTO roomDTO = new RoomController.RoomRequestDTO();
            roomDTO.setCode(room.getCode());
            roomDTO.setCapacity(room.getCapacity());
            results.add(roomDTO);
        }
        return  results;
    }

    public void addNewRoom(RoomController.RoomRequestDTO roomDTO){
        Room newRoom = new Room();

        newRoom.setCode(roomDTO.getCode());
        newRoom.setCapacity(roomDTO.getCapacity());

        roomRepository.save(newRoom);
    }
}
