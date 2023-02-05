package org.example;


import org.example.model.Actor;
import org.example.model.Item;
import org.example.model.Movie;
import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Movie pulpFiction = new Movie("Pulp fiction", 1994);
//            Actor harveyKeitel = new Actor("Harvey Keitel", 81);
//            Actor samuelLJackson = new Actor("Samuel L. Jackson", 72);
//
//            pulpFiction.setActors(new ArrayList<>(List.of(harveyKeitel, samuelLJackson)));
//
//            harveyKeitel.setMovies(new ArrayList<>(Collections.singletonList(pulpFiction)));
//            samuelLJackson.setMovies(new ArrayList<>(Collections.singletonList(pulpFiction)));
//
//            session.save(pulpFiction);
//            session.save(harveyKeitel);
//            session.save(samuelLJackson);

//            Movie movie = session.get(Movie.class, 3);
//            System.out.println(movie.getActors());

//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 2);
//
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//
//            actor.getMovies().add(movie);
//
//            session.save(movie);

            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(movieToRemove);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}
