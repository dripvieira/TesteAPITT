module com.example.comtitansoftwareapi {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.comtitansoftwareapi to javafx.fxml;
    exports com.example.comtitansoftwareapi;
}