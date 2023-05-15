package org.example.Api;

import java.util.Arrays;

public class Tags {
    public static String ul(String id, String content) {
        return "<ul id='" + id + "'>" + content + "</ul>";
    }
    public static String li(String id, String content) {
        return "<li id='" + id + "'>" + content + "</li>";
    }

    public static String img(String id, String blobUrl, String alt) {
        return "<img id='" + id + "' src='" + blobUrl + "' alt='" + alt + "'/>";
    }
    public static String video(String id, String sourceUrl, String alt,String... more) {
        StringBuilder moreAttr=new StringBuilder();
        for (String el:more) {
            moreAttr.append(el).append(" ");
        }
        return "<video id='" + id + "' src='" + sourceUrl + "' alt='" + alt + "' "+ moreAttr +" ></video>";
    }

    public static String h1(String id,String element){
        return "<h1 id='"+id+"'>"+element+"</h1>";
    }
    public static String h2(String id, String element) {
        return "<h2 id='" + id + "'>" + element + "</h2>";
    }
    public static String h3(String id, String element) {
        return "<h3 id='" + id + "'>" + element + "</h3>";
    }
    public static String h4(String id, String element) {
        return "<h4 id='" + id + "'>" + element + "</h4>";
    }

    public static String h5(String id, String element) {
        return "<h5 id='" + id + "'>" + element + "</h5>";
    }

    public static String h6(String id, String element) {
        return "<h6 id='" + id + "'>" + element + "</h6>";
    }
    public static String p(String id, String text) {
        return "<p id='" + id + "'>" + text + "</p>";
    }

    public static String div(String id, String content) {
        return "<div id='" + id + "'>" + content + "</div>";
    }

    public static String span(String id, String text) {
        return "<span id='" + id + "'>" + text + "</span>";
    }
    public static String form(String id, String content) {
        return "<form id='" + id + "'>" + content + "</form>";
    }

    public static String input(String id, String type, String placeholder) {
        return "<input id='" + id + "' type='" + type + "' placeholder='" + placeholder + "'/>";
    }

    public static String button(String id, String text, String onClick) {
        return "<button id='" + id + "' onClick={() => "+onClick+"}>" + text + "</button>";
    }
    public static String a(String id, String href, String text) {
        return "<a id='" + id + "' href='" + href + "'>" + text + "</a>";
    }
}
