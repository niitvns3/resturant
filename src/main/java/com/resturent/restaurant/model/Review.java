package com.resturent.restaurant.model;




import jakarta.persistence.*;
import lombok.*;
import com.resturent.restaurant.enumtype.StatusType;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
 // It's best practice to use lowercase table names
 public class Review 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto-increment in H2
 	@ Column(name = "id", unique = true, nullable = false)
    private Long id;



    
    @Column(name = "review_id")
    private String  review_id; 


    @Column(name = "rating")
    private String rating; 

    @Column(name = "comment")
    private String comment; 

    @Column(name = "visitdate")
    private String visitdate; 

    
    @Enumerated(EnumType.STRING) 
    private StatusType status; 

    
    

    public Review(String rating, String comment,String visitdate,StatusType status, String review_id) {
        this.rating = rating;
        this.comment = comment;
        this.visitdate = visitdate;
        this.status = status;
        this.review_id = review_id;
    }


 }