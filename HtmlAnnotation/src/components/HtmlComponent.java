package components;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.Buffer;

import annotations.Html;

public abstract class HtmlComponent {
	
	public static void createHtml(Class<?> klass) throws IOException{
		if (klass.isAnnotationPresent(Html.class)) {
			FileWriter arq = new FileWriter("src//view//" + klass.getSimpleName() + "Form.html");
			PrintWriter arqGrav = new PrintWriter(arq);
			arqGrav.print(createHtmlString(klass));
			arq.close();
		}
	}
	
	public static String createHtmlString(Class<?> klass) {
		String html = "";
		html += createInitialStruct();
		html += createMiddleStruct(klass);
		html += createEndingStruct();
		return html;
	}
	
	public static String createInitialStruct() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("")
		.append("<html>")
		.append("<head>")
		.append("<link rel=\"stylesheet\" href=\"css/uikit.min.css\" />")
		.append("<script src=\"js/uikit.min.js\"></script>")
		.append("<script src=\"js/uikit-icons.min.js\"></script>")
		.append("</head> ")
		.append("<body>")
		.append("<div class=\"uk-container uk-container-center uk-margin-top uk-margin-large-bottom\">")
		.append("<form class=\"uk-form-horizontal uk-margin-large\">");
		return buffer.toString();
	}
	
	public static String createMiddleStruct(Class<?> klass) {
		StringBuffer buffer = new StringBuffer();
		Class<?> superKlass = klass.getSuperclass();
		for (Field field : superKlass.getDeclaredFields()) {
			if (field.getType() == String.class) {
				buffer.append(createStringInput(field));
			}
		}
		for (Field field : klass.getDeclaredFields()) {
			if (field.getType() == String.class) {
				buffer.append(createStringInput(field));
			}
		}
		return buffer.toString();
	}
	
	public static String createEndingStruct() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("")
		.append("</form>")
		.append("</div>")
		.append("</body>")
		.append("</html>");
		return buffer.toString();
	}
	
	public static String createStringInput(Field field){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<div class=\"uk-margin\">")
		.append("<label class=\"uk-form-label\" for=\"" + field.getName() + "\">")
		.append(field.getName()) //Nome da Label
		.append("</label>")
		.append("<div class=\"uk-form-controls\">")
		.append("<input class=\"uk-input\" id=\"" + field.getName() + "\" type=\"text\">")
		.append("</div>")
		.append("</div>");
		return buffer.toString();
	}
	
}
