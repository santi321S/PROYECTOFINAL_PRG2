package co.edu.unbosque.utils;

import co.edu.unbosque.entidades.Emisora;
import co.edu.unbosque.entidades.Parrillaprogramacion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Funciones {
    public List<String> getListSongs(List<Parrillaprogramacion> list) {
        List<String> tem = new ArrayList<>();
        if (list.size() == 0) {
            return tem;
        }
        for (Parrillaprogramacion p : list) {
            tem.add(p.getIdPistaMusical().getArchivoMp3());
        }
        return tem;
    }

    public String getFirstSong(List<Parrillaprogramacion> list) {
        String tem = "";
        if (list.size() == 0) {
            return tem;
        }
        tem = list.get(0).getIdPistaMusical().getArchivoMp3();
        return tem;
    }

    public String obtenerNombreDiaActual() {
        LocalDate fechaActual = LocalDate.now();
        DayOfWeek diaActual = fechaActual.getDayOfWeek();
        Locale idioma = new Locale("es", "ES");
        String result = diaActual.getDisplayName(TextStyle.FULL, idioma);
        return result;
    }

   public int obtenerPrimerIdEmisora(List<Emisora> listas) {
        if (listas.isEmpty()) {
            return 1;
        }
        return listas.get(0).getId();
    }

}
