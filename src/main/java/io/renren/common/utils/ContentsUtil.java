package io.renren.common.utils;

import com.vdurmont.emoji.EmojiParser;
import com.vladsch.flexmark.Extension;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.AttributeProvider;
import com.vladsch.flexmark.html.AttributeProviderFactory;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.html.Attributes;
import com.vladsch.flexmark.util.options.MutableDataSet;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContentsUtil {
    static class LinkAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, AttributablePart attributablePart, Attributes attributes) {
            if (node instanceof Link) {
                attributes.addValue("target", "_blank");
            }
        }
    }

    public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }
    public static String mdToHtml(String markdown) {

        List<Extension> extensions = Arrays.asList(TablesExtension.create());
//        Parser          parser     = Parser.builder().extensions(extensions).build();
//        Node document   = parser.parse(markdown);
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document   = parser.parse(markdown);
        String content = renderer.render(document);
        content = emoji(content);

        // 支持网易云音乐输出
        if (content.contains(Constant.MP3_PREFIX)) {
            content = content.replaceAll(Constant.MUSIC_REG_PATTERN, Constant.MUSIC_IFRAME);
        }
        // 支持gist代码输出
        if ( content.contains(Constant.GIST_PREFIX_URL)) {
            content = content.replaceAll(Constant.GIST_REG_PATTERN, Constant.GIST_REPLATE_PATTERN);
        }
        return content;
    }

}
