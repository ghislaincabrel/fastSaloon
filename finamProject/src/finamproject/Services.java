/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finamproject;

import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class Services {

    private String saloonName;
    private String email;
    private String town;
    private String quater;
    private String description;
    private String contact;
    private int price;
    private int id;
    private String haid_Style;
    private int password;
    private byte[] saloonImage;
    private byte[] image;

    public Services(String saloonName, String town, String quater, String description, String contact, int password, byte[] saloonImage) {

        this.saloonName = saloonName;
        this.town = town;
        this.quater = quater;
        this.description = description;
        this.contact = contact;
        this.password = password;
        this.saloonImage = saloonImage;
    }

    public Services(String email, String saloonName, String quater, String description, String contact) {
        this.email = email;
        this.saloonName = saloonName;
        this.quater = quater;
        this.description = description;
        this.contact = contact;
    }

    public Services(int id, String haid_Style, int price, byte[] image) {
        this.id = id;
        this.haid_Style = haid_Style;
        this.price = price;
        this.description = description;
        this.image = image;

    }

    public String getSaloonName() {
        return saloonName;
    }

    public String getTown() {
        return town;
    }

    public String getQuater() {
        return quater;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public byte[] getSaloonImage() {
        return saloonImage;
    }

    public String getHaid_Style() {
        return haid_Style;
    }

    public int getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public ImageIcon getImage1() {
        return new ImageIcon(getImage());
    }

    public String getEmail() {
        return email;
    }

}
