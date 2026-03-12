package com.avila.tarea1.controller;

import org.springframework.web.bind.annotation.*;
import com.avila.tarea1.Producto;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private List<Producto> inventario = new ArrayList<>();

    public ProductoController() {
        inventario.add(new Producto(101, "Zapatillas Puma", 60.000));
        inventario.add(new Producto(102, "Polera Deportiva", 20.000));
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return inventario;
    }

    @PostMapping
    public String agregarProducto(@RequestBody Producto nuevo) {
        inventario.add(nuevo);
        return "Éxito: El producto '" + nuevo.getNombre() + "' ha sido sincronizado en el inventario.";
    }
}