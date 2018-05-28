package com.bartek.util;

import com.bartek.domain.App;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupDataLoader implements ServletContextListener {

    private static SessionFactory sessionFactory;

    Logger logger = LoggerFactory.getLogger(StartupDataLoader.class);

    public static synchronized Session openSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            configuration.configure();

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        }
        return sessionFactory.openSession();
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Session session = openSession();
        session.beginTransaction();
        App app1 = new App("Chmura!", "cloud.jpg", "Aplikacja Chmura! jest miejscem, w którym dziej¹ siê cuda. Firmy dzia³aj¹ w chmurach. Programici nie potrzebuj¹ administratorów, jedzenia i picia w zasadzie te¿ nie. Mo¿esz ogl¹daæ telewizjê na tablecie, siedzaæ na kanapie; nie musisz w ogóle patrzeæ na telewizor! ci¹gnij aplikacjê Chmura! z chmury i dowiadcz tej cudownej potêgi!");
        session.save(app1);
        logger.info("Zapisujê " + app1.getName());

        App app2 = new App("Zamykacz transakcji", "pointing.jpg", "Wysokoenergetyczna aplikacja wspomagaj¹ca energicznych sprzedawców. Twórz pe³ne energii kalendarze i arkusze. Gdy jeste w miecie i energicznie nawi¹zujesz kontakty, chcesz prezentowaæ swe naenergetyzowane foldery, pokazuj¹ce, ¿e te¿ masz w sobie mnóstwo energii.");
        session.save(app2);
        logger.info("Zapisujê " + app2.getName());

        App app3 = new App("Miêdzynarodowy turniej pi³karski", "ball.jpg", "Ta ma³a aplikacja oferuje Ci radoæ gry w pi³kê no¿n¹, poza tym, ¿e grasz na ekranie dotykowym, zamiast biegaæ i kopaæ albo w ogóle siê ruszaæ. Poza tym zapewnia podobne wra¿enia.");
        session.save(app3);
        logger.info("Zapisujê " + app3.getName());

        App app4 = new App("Kolejna gra o kryszta³ach", "brilliant.jpg", "Olniewaj¹ca aplikacja, w której ³¹czysz kryszta³y tego samego koloru, by zniknê³y. Co jak Tetris. W sumie przypomina tuzin innych gier, w których ³¹czysz kryszta³y tego samego koloru.");
        session.save(app4);
        logger.info("Zapisujê " + app4.getName());

        App app5 = new App("Temperówka", "pencil.jpg", "Ostrz o³ówki, wk³adaj¹c je do gniazda Bluetooth i wciskaj¹c przycisk. Ta aplikacja wyciska ze sprzêtu wszystko!");
        session.save(app5);
        logger.info("Zapisujê " + app5.getName());

        App app6 = new App("Namierzacz zszywaczy", "stapler.jpg", "Czy kto ci¹gle po¿ycza sobie Twój zszywacz? To typowy problem w biurach. Nasza aplikacja biznesowa sprawi, ¿e ju¿ nigdy nie bêdziesz musia³ siê zastanawiaæ, gdzie podziewa siê Twój zszywacz.");
        session.save(app6);
        logger.info("Zapisujê " + app6.getName());

        App app7 = new App("Sfrustrowane Flamingi", "flamingo.jpg", "Ma³a aplikacja pozwalaj¹ca na ciskanie wielkimi ptakami na lewo i prawo bez powodu. Chyba nie zastanawiasz siê czemu s¹ sfrustrowane?");
        session.save(app7);
        logger.info("Zapisujê " + app7.getName());

        App app8 = new App("Wideokonferencje Grype", "laptop.jpg", "Dzwoñ za darmo lokalnie i za granicê, równie¿ z transmisj¹ obrazu, u¿ywaj¹c domowego po³¹czenia internetowego i naszego produktu. W sumie nasz aplikacja zadzia³a jeszcze lepiej jeli skorzystasz z po³¹czenia internetowego Twojego pracodawcy!");
        session.save(app8);
        logger.info("Zapisujê " + app8.getName());

        App app9 = new App("Czytnik e-booków", "book.jpg", "Nasza aplikacja sprawi, ¿e bêdziesz móg³ czytaæ ksi¹¿ki na komputerze albo na dowolnym urz¹dzeniu mobilnym.  Polecamy \"Hibernate Search by Example\".");
        session.save(app9);
        logger.info("Zapisujê " + app9.getName());

        App app10 = new App("Przegl¹darka pod kopu³¹", "orangeswirls.jpg", "Ta cudowna aplikacja pozwala nam ledziæ Twoj¹ aktywnoæ w Internecie. Mo¿emy odgadn¹æ, gdzie mieszkasz, co jad³e dzisiaj na niadanie albo jakie s¹ Twoje najwiêksze sekrety. Aha, w aplikacjê jest jeszcze wbudowana przegl¹darka stron WWW.");
        session.save(app10);
        logger.info("Zapisujê " + app10.getName());

        App app11 = new App("Internetowe radio Atena", "jamming.jpg", "S³uchaj swoich ulubionych piosenek w radiu internetowym! Kiedy polubisz jaki utwór, nasza aplikacja zagra Ci wiêcej podobnych kompozycji. A przynajmniej zagra wiêcej piosenek ... ¯eby byæ szczerym, czasem wcale nie s¹ takie podobne  :(");
        session.save(app11);
        logger.info("Zapisujê " + app11.getName());

        App app12 = new App("Mapa podró¿y", "compass.jpg", "Potrzebujesz wskazówek, by dotrzeæ do celu?  Nasza aplikacja GPS na pewno wygeneruje wystarczaj¹co du¿o propozycji, by dotar³ do celu!  Prêdzej czy póniej.");
        session.save(app12);
        logger.info("Zapisujê " + app12.getName());

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        if(!sessionFactory.isClosed()){
            sessionFactory.close();
        }

    }
}
