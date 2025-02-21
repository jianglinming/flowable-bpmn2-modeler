package com.guzt.flowable.modeler;

import org.flowable.ui.modeler.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.service.BpmnDisplayJsonConverter;
import org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * 启动 main方法
 *
 * @author <a href="mailto:Ronaldo@middol.com">Ronaldo</a>
 */
@Import({ApplicationConfiguration.class, AppDispatcherServletConfiguration.class})
@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        String banner ="===================================================== \n"+
                "       __                              __                        __                            __                      __              __ \n" +
                "      /  |                            /  |                      /  |                          /  |                    /  |            /  |\n" +
                "      $$ |____    ______    ______   _$$ |_           _______  _$$ |_     ______    ______   _$$ |_           ______  $$ |   __       $$ |\n" +
                "      $$      \\  /      \\  /      \\ / $$   |         /       |/ $$   |   /      \\  /      \\ / $$   |         /      \\ $$ |  /  |      $$ |\n" +
                "      $$$$$$$  |/$$$$$$  |/$$$$$$  |$$$$$$/         /$$$$$$$/ $$$$$$/    $$$$$$  |/$$$$$$  |$$$$$$/         /$$$$$$  |$$ |_/$$/       $$ |\n" +
                "      $$ |  $$ |$$ |  $$ |$$ |  $$ |  $$ | __       $$      \\   $$ | __  /    $$ |$$ |  $$/   $$ | __       $$ |  $$ |$$   $$<        $$/ \n" +
                "      $$ |__$$ |$$ \\__$$ |$$ \\__$$ |  $$ |/  |       $$$$$$  |  $$ |/  |/$$$$$$$ |$$ |        $$ |/  |      $$ \\__$$ |$$$$$$  \\        __ \n" +
                "      $$    $$/ $$    $$/ $$    $$/   $$  $$/       /     $$/   $$  $$/ $$    $$ |$$ |        $$  $$/       $$    $$/ $$ | $$  |      /  |\n" +
                "      $$$$$$$/   $$$$$$/   $$$$$$/     $$$$/        $$$$$$$/     $$$$/   $$$$$$$/ $$/          $$$$/         $$$$$$/  $$/   $$/       $$/ \n" +
                "                                                                                                                                          ";
        SpringApplication.run(Application.class, args);

        logger.info(banner);
    }

}
