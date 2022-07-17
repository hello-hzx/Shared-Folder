package com.jon;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jmingemail@qq.com
 * @date 2022/7/16
 */
public class XmlTest {

    private static Map<String, ActionConfig> actionConfigs = new HashMap<>();
    private static String className = "";


    public static void main(String[] args) throws Exception {
        InputStream stream = XmlTest.class.getClassLoader().getResourceAsStream("do.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(stream);
        Element element = document.getDocumentElement();
        readXml(element, null);
        actionConfigs.forEach((k, v) -> System.out.println(k + ":::" + v));
    }

    private static void readXml(Element element, ActionConfig actionConfig) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            if (child instanceof Element) {
                String nodeName = child.getNodeName();
                switch (nodeName) {
                    case "controller":
                        Element childElement = (Element) child;
                        className = childElement.getAttribute("class");
                        readXml(childElement, actionConfig);
                        break;
                    case "method":
                        readXml((Element) child, actionConfig);
                        break;
                    default:
                        String textChild = child.getTextContent().trim();
                        if ("name".equals(child.getNodeName())) {
                            actionConfig = initActionConfig(actionConfig);
                            actionConfig.setMethodName(textChild);
                        } else {
                            actionConfig = initActionConfig(actionConfig);
                            actionConfigs.put(textChild, actionConfig);
                        }
                }
            }
        }
    }

    private static ActionConfig initActionConfig(ActionConfig actionConfig) {
        if (actionConfig == null) {
            return new ActionConfig(className);
        }
        return actionConfig;
    }


}
