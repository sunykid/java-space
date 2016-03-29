package org.icase.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.icase.hibernate.bean.Geek;
import org.icase.hibernate.bean.IdCard;
import org.icase.hibernate.bean.Person;
import org.icase.hibernate.bean.Project;

/**
 * Hello world!
 *
 */
public class HibernateDemo1 
{
	private static final Logger LOGGER = Logger.getLogger("HibernateDemo1.class"); 
    public static void main( String[] args )
    {
        HibernateDemo1.run();
    }
    
    public static void run(){
    	SessionFactory sessionFactory = null;
    	Session session = null;
    	try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			/**5.1.0版本在configure中已经进行了serviceRegistry处理 ，添加以下内容后会报错，定义的bean对象招不到**/
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			/*****************************/
			session = sessionFactory.openSession();
//			persistPerson(session);
//			persistGeek(session);
//			persistGeekAndCard(session);
			persistGeekAndProject(session);
		} catch (HibernateException e) {
			LOGGER.log(Level.SEVERE,e.getMessage(),e);
		}finally{
			if(session!=null){session.close();}
			if(sessionFactory!=null){sessionFactory.close();}
		}
    }

	private static void persistPerson(Session session) {
		Transaction transaction = null;
		try {
			
			transaction = session.getTransaction();
			transaction.begin();
			Person p = new Person();
			p.setName("zhugeliang3");
			session.save(p);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			throw e;
		}
	}
	
	private static void persistGeek(Session session) {
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			
			Geek geek = new Geek();
			geek.setName("Geek");
			geek.setFavouriteProgrammingLanguate("Java");
			session.save(geek);
			geek = new Geek();
			geek.setName("Thomas");
			geek.setFavouriteProgrammingLanguate("C#");
			session.save(geek);
			geek = new Geek();
			geek.setName("Christian");
			geek.setFavouriteProgrammingLanguate("Java");
			session.save(geek);
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			throw e;
		}
	}
	
	private static void persistGeekAndCard(Session session) {
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			
			Geek geek = new Geek();
			geek.setName("Geek");
			geek.setFavouriteProgrammingLanguate("grooxy");
			session.save(geek);
			
			IdCard card = new IdCard();
			card.setIdNumber("3713221199123456");
			card.setIssueDate(new Date());
			geek.setIdCard(card);
			 session.save(card);//可以返回新创建对象的标识符
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			throw e;
		}
	}

	private static void persistGeekAndProject(Session session) {
		Transaction transaction = null;
		try {
			transaction = session.getTransaction();
			transaction.begin();
			
			Project p = new Project();
			p.setTitle("My First Project!");
			
			Geek geek = new Geek();
			geek.setFavouriteProgrammingLanguate("JAVA");
			geek.setName("sunkuankuan");
			
			Set<Project> projects = new HashSet<>();
			projects.add(p);
			
			Set<Geek> geeks = new HashSet<>();
			geeks.add(geek);
			
			geek.setProjects(projects);
			p.setGeeks(geeks);
			
			session.save(p);
			session.save(geek);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null){
				transaction.rollback();
			}
			throw e;
		}
	}

}
