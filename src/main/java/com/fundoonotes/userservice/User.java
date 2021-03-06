package com.fundoonotes.userservice;

import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Purpose: This is User model class contains fields related to user with
 * setters/getters and constructor.
 * 
 * {@link Entity @Entity}, @Entity annotation to the User class, which marks
 * this class as an entity bean. {@link Table @Table}, @Table annotation allow
 * you to specify the details of the table that will be used to persist the
 * entity in database. {@link Id @Id} @Id annotation will automatically
 * determine the most appropriate primary key
 * {@link GeneratedValue @GeneratedValue} @GeneratedValue annotation, which
 * takes parameter strategy and here i am using AUTO to generate Id
 * automatically {@link Column @Column} @Column annotation is used to specify
 * the details of the column to which a field or property will be mapped.
 * {@link OneToMany @OneToMany} @One-to-Many mapping implemented using a Set
 * java collection that does not contain any duplicate element.
 * 
 * @author SANA SHAIKH
 * @since 21Mar 2018
 *
 */
@Entity
@Table(name = "ToDoRegistration")
public class User
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "userId")
   private int userId;

   @Column
   private String name;

   @Column(unique = true)
   private String email;

   @Column
   private String password;

   @Column
   private String mobileNo;

   @Column
   private boolean status;
  
   @JsonIgnore
   @Lob
   @Column(name = "userProfile", columnDefinition="BLOB")
   private Blob userProfile;

   /*@JsonIgnore
   @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
   private Set<Notes> notes;*/

   public User(UserDTO userdto)
   {
      this.name = userdto.getName();
      this.email = userdto.getEmail();
      this.password = userdto.getPassword();
      this.mobileNo = userdto.getMobileNo();
   }

   public User()
   {
      //TODO Auto-generated constructor stub
   }

   public int getUserId()
   {
      return userId;
   }

   public void setUserId(int userId)
   {
      this.userId = userId;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public String getMobileNo()
   {
      return mobileNo;
   }

   public void setMobileNo(String mobileNo)
   {
      this.mobileNo = mobileNo;
   }

/*   public Set<Notes> getNotes()
   {
      return notes;
   }

   public void setNotes(Set<Notes> notes)
   {
      this.notes = notes;
   }*/

   public boolean isStatus()
   {
      return status;
   }

   public void setStatus(boolean status)
   {
      this.status = status;
   }

   public Blob getUserProfile()
   {
      return userProfile;
   }

   public void setUserProfile(Blob userProfile)
   {
      this.userProfile = userProfile;
   }

}
