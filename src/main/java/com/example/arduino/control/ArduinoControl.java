package com.example.arduino.control;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/arduino")
public class ArduinoControl {
    private static Map<String, String> o = new HashMap<>();

    @GetMapping("/door")
    public Map<String, String> door() {
        if (o.get("door") == null) {
            o.put("door", "close");
        }
        return Collections.singletonMap("status", o.get("door"));
    }

    @GetMapping("/light")
    public Map<String, String> light() {
        if (o.get("light") == null) {
            o.put("light", "on");
        }
        return Collections.singletonMap("status", o.get("light"));
    }

    @GetMapping("/temp")
    public Map<String, String> temp() {
        if (o.get("temp") == null) {
            o.put("temp", "26.2");
        }
        return Collections.singletonMap("size", o.get("temp"));
    }

    @PostMapping("/door")
    public Map<String, String> setDoor(@RequestBody Map<String, String> obj) {
        o.put("door", obj.get("status"));
        return Collections.singletonMap("status", o.get("door"));
    }

    @PostMapping("/light")
    public Map<String, String> setLight(@RequestBody Map<String, String> obj) {
        o.put("light", obj.get("status"));
        return Collections.singletonMap("status", o.get("light"));
    }

    @PostMapping("/temp")
    public Map<String, String> setTemp(@RequestBody Map<String, String> obj) {
        o.put("temp", obj.get("size"));
        return Collections.singletonMap("size", o.get("temp"));
    }
}

