package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static final int CATEGORIES_IN_ROUND_COUNT = 4;
    public static final int TUNES_IN_CATEGORY_COUNT = 4;
    public static final int TUNES_IN_SUPER_GAME_COUNT = 7;
    private static final String TUNES = "tunes";
    private static final String ROUND = "round";
    private static final String CATEGORY = "category";
    private static final String _C_ATEGORY = "Category";
    private static final String TUNE = "tune";
    private static final String SUPERGAME = "supergame";
    private static final String IMAGES = "/images/";
    private static final String NOTES = IMAGES + "notes/";
    private static final String ICON = IMAGES + "icon.png";
    private static final String FXML = "/fxml/";
    private static final String MAIN_FXML = FXML + "main.fxml";
    private static final String GAME_FXML = FXML + "game.fxml";
    private static final String SUPER_GAME_FXML = FXML + "superGame.fxml";
    private static final String SUPER_GAME_SETTINGS_FXML = FXML + "superGameSettings.fxml";
    private static final String SETTINGS_FXML = FXML + "settings.fxml";
    private static final String PRELOADER = FXML + "preloader.fxml";
    private static final String FXML_EXT = ".fxml";
    private static final String SETTINGS_ROUND = "settingsRound";
    private static final int ROUNDS_COUNT = 3;

    private FileUtil() {
    }

    public static void createDirectories() {
        createDir(TUNES);
        for (int roundNumber = 1; roundNumber <= ROUNDS_COUNT; roundNumber++) {
            String roundPath = TUNES + "/" + ROUND + roundNumber;
            createDir(roundPath);
            for (int categoryNumber = 1; categoryNumber <= CATEGORIES_IN_ROUND_COUNT; categoryNumber++) {
                String categoryPath = roundPath + "/" + CATEGORY + categoryNumber;
                createDir(categoryPath);
                for (int tuneNumber = 1; tuneNumber <= TUNES_IN_CATEGORY_COUNT; tuneNumber++) {
                    createDir(categoryPath + "/" + TUNE + tuneNumber);
                }
            }
        }
        createDir(TUNES + "/" + SUPERGAME);
    }

    private static void createDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public static File getMP3File(int roundNumber, int categoryNumber, int tuneNumber) {
        return new File(TUNES + "/" + ROUND + roundNumber + "/" + CATEGORY + categoryNumber + "/" + TUNE + tuneNumber + "/" + tuneNumber + ".mp3");
    }

    public static File getMP3File(int tuneNumber) {
        return new File(TUNES + "/" + SUPERGAME + "/" + tuneNumber + ".mp3");
    }

    public static void saveMP3File(File mp3File, int roundNumber, int categoryNumber, int tuneNumber) {
        saveMP3File(mp3File, TUNES + "/" + ROUND + roundNumber + "/" + CATEGORY + categoryNumber + "/" + TUNE + tuneNumber + "/" + tuneNumber + ".mp3");
    }

    public static void saveMP3File(File mp3File, int tuneNumber) {
        saveMP3File(mp3File, TUNES + "/" + SUPERGAME + "/" + tuneNumber + ".mp3");
    }

    private static void saveMP3File(File mp3File, String path) {
        try (FileInputStream fileInputStream = new FileInputStream(mp3File);
             FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            byte[] bytes = new byte[1024];
            while (fileInputStream.read(bytes) != -1) {
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image getNoteImage(String color) {
        return new Image(FileUtil.class.getResource(NOTES + color).toString());
    }

    public static Image getIconImage() {
        return new Image(FileUtil.class.getResource(ICON).toString());
    }

    public static Parent loadMainFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(MAIN_FXML));
    }

    public static Parent loadGameFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(GAME_FXML));
    }

    public static Parent loadSettingsFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(SETTINGS_FXML));
    }

    public static Parent loadRoundFromFXML(int roundNumber) throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(FXML + ROUND + roundNumber + FXML_EXT));
    }

    public static Parent loadPreloaderFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(PRELOADER));
    }

    public static Parent loadSettingsRoundFromFXML(int roundNumber) throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(FXML + SETTINGS_ROUND + roundNumber + FXML_EXT));
    }

    public static Parent loadSettingsRoundCategoryFromFXML(int roundNumber, int categoryNumber) throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(FXML + SETTINGS_ROUND + roundNumber + _C_ATEGORY + categoryNumber + FXML_EXT));
    }

    public static Parent loadSuperGameFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(SUPER_GAME_FXML));
    }

    public static Parent loadSuperGameSettingsFromFXML() throws IOException {
        return FXMLLoader.load(FileUtil.class.getResource(SUPER_GAME_SETTINGS_FXML));
    }

}
