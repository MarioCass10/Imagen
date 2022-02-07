package institute.immune.imagen;

public class Cancion {

    //Atributos de la clase
    private int audio;
    private int imagen;

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


    //Constructor con el mismo nombre de la clase
    public Cancion(int canciones, int imagen){
        audio = canciones;
        this.imagen =imagen;
    }

    public int getAudio()
    {
        return audio;
    }

    // Setter
    public void setAudio(int newCancion) {
        this.audio = newCancion;
    }

}

