
package Model;

import java.io.Serializable;

/**
 *
 * @author luuhuy
 */
public class DoUong implements Serializable{
    private int id;
    private String Name;
    private int price;

    public DoUong() {
    }

    public DoUong(String Name, int price) {
        this.Name = Name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
