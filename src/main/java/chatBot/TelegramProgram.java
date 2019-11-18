package chatBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import tasks_extractor.QuizTasksExtractor;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class TelegramProgram {
    public static String questionPath = "src\\main\\resources\\questions";

    public static void main(String[] args) {
        ApiContextInitializer.init();
        /*File dir = new File(System.getProperty("user.dir"));
        System.out.println(dir.getAbsolutePath());*/
        QuizTasksExtractor extractor = new QuizTasksExtractor(questionPath);
        TelegramBot bot = new TelegramBot();
        TelegramBotLogic telegramBotLogic = new TelegramBotLogic(bot, extractor);
        bot.subscribe(telegramBotLogic);
        try {
            TelegramBotsApi botapi = new TelegramBotsApi();
            botapi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
