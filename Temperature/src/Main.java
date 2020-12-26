import ru.academits.tunkenov.temperature.model.Converter;
import ru.academits.tunkenov.temperature.model.TemperatureConverter;
import ru.academits.tunkenov.temperature.view.DesktopView;
import ru.academits.tunkenov.temperature.view.View;

public class Main {
    public static void main(String[] args) {
        Converter temperatureConverter = new TemperatureConverter();

        View view = new DesktopView(temperatureConverter);

        view.start();
    }
}
