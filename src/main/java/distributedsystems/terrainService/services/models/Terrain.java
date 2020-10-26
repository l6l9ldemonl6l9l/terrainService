package distributedsystems.terrainService.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Terrain {

    @Id
    private UUID id;
    @Column(unique = true)
    private String name;
    private int sizeBeauty;


    public Terrain(String name, int sizeBeauty) {
        this.name = name;
        this.sizeBeauty = sizeBeauty;
        this.id = UUID.randomUUID();
        System.out.println("ке2\n");
    }

    public void showInformationAboutTerrain() {
        System.out.print("Месность :" + name + ". Красота:");

        if (sizeBeauty < 20) {
            System.out.println(" ниже среднего.");
        }

        if (sizeBeauty >= 20 & sizeBeauty <= 60) {
            System.out.println(" красиво.");
        }

        if (sizeBeauty > 60) {
            System.out.println(" очень красиво.");
        }
    }
    public int getSizeBeauty(){
        return sizeBeauty;
    }

}
