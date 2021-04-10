package pl.deren.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {

    @Autowired
    PhoneRepository phoneRepository;

    @PostMapping ("id")
    public int myPost(){
        return 123;
    }

    @PostMapping ("/phone/{brand}")
    public String myBrandGet(@PathVariable String brand) {
        return brand;
    }
    @DeleteMapping("/color/{user}")
    public String myDeleteColor(@PathVariable String user, @RequestParam String color){
        return color + " "+ user+" ";
    }
    @PutMapping("/time/{screen}")
    public String myPut(@PathVariable int screen,@RequestParam int time, @RequestHeader String name){
        return "Time:  " + time + "Screen:   " + screen + "Name:  " + name;
    }
    @PostMapping("/phone2")
    public String phone2(@RequestBody PhoneReq phone2){
        return phone2.toString();
}
    @GetMapping(value= "/test")
    public Iterable<Phone> phone2(){
        return phoneRepository.findAll();
    }
    @GetMapping(value= "/test/{id}")
    public Phone phone2(@PathVariable long id) {
        return phoneRepository.findById(id).get();
    }
    @PostMapping(value = "/test2")
    public long method(@RequestBody PhoneReq phoneReq){
        Phone phone = new Phone(4, phoneReq.getNumber(), phoneReq.getMessage());
        Phone save = phoneRepository.save(phone);
        return save.getId();
    }
}
