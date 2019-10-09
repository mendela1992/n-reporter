package nReporter.helpers;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class MarkupHelpers {
    private static MarkupHelpers ourInstance = new MarkupHelpers();
    private static StringBuilder builder;

    /**
     * Private constructor
     */
    private MarkupHelpers() {
    }

    /**
     * Set Un order list
     *
     * @param list list of elements.
     * @return MarkUpHelper instance
     */
    public static MarkupHelpers unOrderList(List<String> list) {
        builder = new StringBuilder();
        builder.append("<ul class=\"list-group list-group-flush\">");
        list.forEach(s -> builder.append("\n").append("<li class=\"list-group-item\">").append(s).append("</li>"));
        builder.append("</ul>");
        return codeBlock(builder.toString());
    }

    /**
     * Set table
     *
     * @param table Data of table
     * @return MarkUpHelper instance
     */
    public static MarkupHelpers table(LinkedList<LinkedList<String>> table) {
        return table(table, true);
    }

    /**
     * Set table
     *
     * @param table Data of table
     * @param isHeader Consider first row as header or not.
     * @return MarkUpHelper instance
     */
    public static MarkupHelpers table(LinkedList<LinkedList<String>> table, boolean isHeader) {
        builder = new StringBuilder();
        int startIndex;
        if (isHeader)
            startIndex = 1;
        else
            startIndex = 0;

        builder.append("<table class='table table-hover' >");
        if (isHeader){
            builder.append("<thead class='bg-dark'>");
            table.get(0).forEach(header -> builder.append("\n").append("<th>").append(header).append("</th>"));
            builder.append("</thead>");
        }
        builder.append("<tbody>");
        IntStream.range(startIndex, table.size()).mapToObj(table::get).forEach(row -> {
            builder.append("<tr>");
            row.forEach(column -> builder.append("\n").append("<td>").append(column).append("</td>"));
            builder.append("<tr>");
        });
        builder.append("</tbody>")
                .append("</table>");

        return codeBlock(builder.toString());
    }

    /**
     * Set Code block
     *
     * @param code Code block
     * @return MarkUpHelper instance
     */
    public static MarkupHelpers codeBlock(String code) {
        builder = new StringBuilder();
        builder.append("<pre class='mt-3'>")
                .append("\n")
                .append("<code>")
                .append(code)
                .append("</code>")
                .append("</pre>");
        return ourInstance;
    }

    /**
     * Markup as String
     *
     * @return String of MarkUp element.
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}
