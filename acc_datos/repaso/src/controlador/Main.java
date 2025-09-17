package controlador;

import java.time.LocalDate;

import modelo.Canal;
import modelo.Retrans;
import modelo.Usuario;
import services.CanalServ;
import services.RetransServ;
import services.UsuarioServ;

public class Main {

	public static void main(String[] args) {
		Usuario usuario1 = new Usuario(1, "Carlos Sánchez", "carlos@email.com", LocalDate.of(2023, 5, 20), true);
        Usuario usuario2 = new Usuario(2, "Ana García", "ana@email.com", LocalDate.of(2023, 6, 10), true);
        Canal canal1 = new Canal(1, LocalDate.of(2023, 5, 10));
        Canal canal2 = new Canal(2, LocalDate.of(2024, 3, 15));
        Retrans retrans1 = new Retrans(101, 120);  
        Retrans retrans2 = new Retrans(102, 150);
        Usuario usuario3 = new Usuario(3, "Luis Martínez", "luis@email.com", LocalDate.of(2023, 7, 5), false);
        Canal canal3 = new Canal(3, LocalDate.of(2025, 1, 1));
        Retrans retrans3 = new Retrans(103, 180);
        
        UsuarioServ u = new UsuarioServ();
        u.addUser(usuario2);
        u.addUser(usuario1);
        u.addUser(usuario3);
        u.bajaUser(usuario2);
        System.out.println(u.getRepositorio().getUsuarios());
        System.out.println(u.leeUser(usuario1));
        
        CanalServ c = new CanalServ();
        c.addCanal(canal1);
        c.addCanal(canal2);
        c.addCanal(canal3);
        c.bajaCanal(canal2);
        System.out.println(c.getRepositorio().getCanales());
        System.out.println(c.leCanal(canal1));
        
        RetransServ r = new RetransServ();
        r.addRetrans(retrans1);
        r.addRetrans(retrans2);
        r.addRetrans(retrans3);
        r.bajaRetrans(retrans2);
        System.out.println(r.getRepositorio().getRetransmisiones());
        System.out.println(r.leeRetrans(retrans1));

	}

}
