package src.models;

import org.json.simple.JSONObject;
import src.gui.MainAppButton;
import src.helper.Constants;

import java.time.LocalDateTime;

/**
 *La class MyImage liste tous les attributs de chaque image.
 * les images restent modifiable au niveau des attributs.
 *
 * @see #setName (String str)
 */
public class MyImage {
    private String path;
    private String name;
    private String creation_date;
    private String modification_date;
    private JSONObject img_json;
    private MyJsonManager jsonMan;
    private MainAppButton btn=null;

    /**
     * constructeur MyImage
     * les différentes variables listée ont été initialisées dans le constructeur ci-dessous
     * @param path chemin de l'image
     * @param name nom de l'image
     * @param creation_date date de création de l'image
     * @param modification_date dernière date de modification
     * @param img_json
     * @param jsonMan
     */
    public MyImage(String path, String name, String creation_date, String modification_date, JSONObject img_json, MyJsonManager jsonMan) {
        this.path=path;
        this.name=name;
        this.creation_date=creation_date;
        this.modification_date=modification_date;
        this.img_json=img_json;
        this.jsonMan=jsonMan;
    }
    public String getName() { return this.name; }
    public String getPath() { return this.path; }
    public String getCreation_date() { return this.creation_date; }
    public String getModification_date() { return this.modification_date; }
    public void setName(String str) {
        this.name = str;
        setValueToJson("name", name);
    }

    /**
     *constructeur setModificationDateNow
     * ceci va permettre de générer un attributs lié à la date de modification
     */
    public void setModificationDateNow() {
        modification_date = Constants.DATETIME_FILE_FORMATTER.format(LocalDateTime.now());
        setValueToJson("modification_date", modification_date);

    }

    /**
     * COnstructeur setValueToJason qui va permettre de
     * @param key
     * @param value
     */
    private void setValueToJson(String key, String value) {
        this.img_json.put(key,value);
        jsonMan.updateJson();
        System.out.println(key + ":" + value);
    }

    /**
     * Constructeur deleteImage
     * ceci est un constructeur qui va permettre de supprimer l'image de la galerie, grâce à la méthode removeObject.
     */
    public void deleteImage() {
        jsonMan.removeObject(this.img_json);
        jsonMan.updateJson();
    }

    /**
     * Constructeur setImageButton
     * @param btn le bouton utilisé pour
     */
    public void setImageButton(MainAppButton btn) {
        this.btn=btn;
    }
    public MainAppButton getImageButton() {
        return btn;
    }

}
