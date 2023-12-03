module taroapp.taro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens taroapp.taro to javafx.fxml;
    exports taroapp.taro;
    exports taroapp.taro.oneCard;
    exports taroapp.taro.threeCard;
    opens taroapp.taro.oneCard to javafx.fxml;
    opens taroapp.taro.threeCard to javafx.fxml;
}