package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FileOpenManagerTest {

    private FileOpenManager fileOpenManager = new FileOpenManager();

    private String photoshop = "Adobe Photoshop";
    private String browser = "Google Chrome";
    private String image = "Image Tool";

    private String psd = ".psd";
    private String html = ".html";
    private String png = ".png";
    private String jpg = ".jpg";

    @BeforeEach
    void setUp() {
        fileOpenManager.register(browser, html);
        fileOpenManager.register(photoshop, psd);
        fileOpenManager.remove(".png");
        fileOpenManager.register(image, png);
        fileOpenManager.register(image, jpg);
    }

    @Test
    void shouldShowAllApps() {
        Set<String> actual = fileOpenManager.showAllApps();
        Set<String> expected = new HashSet<>();
        expected.add(photoshop);
        expected.add(image);
        expected.add(browser);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowAllTypes() {
        Collection<String> actual = fileOpenManager.showAllTypes();
        List<String> expected = Arrays.asList(html, jpg, png, psd);
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowNameByType() {
        String expected = "Image Tool";
        String actual = fileOpenManager.getName(".jpg");
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowNameByTypeIfUsedUppercase() {
        String expected = "Image Tool";
        String actual = fileOpenManager.getName(".PNG");
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowNameByTypeIfUsedNoExistType() {
        String actual = fileOpenManager.getName(".jpeg");
        assertNull(actual);
    }

    @Test
    void removeConnection() {
        String actual = fileOpenManager.remove("Google Chrome");
        assertNull(actual);
    }
}