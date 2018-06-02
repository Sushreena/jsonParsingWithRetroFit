package com.sushinamu.dell.jsonparsing;

public class MenuModalClass {

    public String getUpdate_Date() {
        return Update_Date;
    }

    public void setUpdate_Date(String update_Date) {
        Update_Date = update_Date;
    }

    public String getItem_Desc() {
        return Item_Desc;
    }

    public void setItem_Desc(String item_Desc) {
        Item_Desc = item_Desc;
    }

    public String getItem_Price() {
        return Item_Price;
    }

    public void setItem_Price(String item_Price) {
        Item_Price = item_Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getItem_Desc_English() {
        return Item_Desc_English;
    }

    public void setItem_Desc_English(String item_Desc_English) {
        Item_Desc_English = item_Desc_English;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getMenu_Type() {
        return Menu_Type;
    }

    public void setMenu_Type(String menu_Type) {
        Menu_Type = menu_Type;
    }

    private String Update_Date;

        private String Item_Desc;

        private String Item_Price;

        private String Image;

        private String Item_Desc_English;

        private String Id;

        private String Item_Name;

        private String Menu_Type;


        @Override
        public String toString()
        {
            return "ClassPojo [Update_Date = "+Update_Date+", Item_Desc = "+Item_Desc+", Item_Price = "+Item_Price+", Image = "+Image+", Item_Desc_English = "+Item_Desc_English+", Id = "+Id+", Item_Name = "+Item_Name+", Menu_Type = "+Menu_Type+"]";
        }
    }



