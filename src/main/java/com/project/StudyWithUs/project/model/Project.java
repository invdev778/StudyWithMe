package com.project.StudyWithUs.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.StudyWithUs.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Project")
public class Project {

    //@JsonIgnore
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "member_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@Column(name = "member_id")
    private Member member_id;

    //@Column(name = "title")
    private String title;

    @Lob
    //@Column(name = "content")
    private String content;

    //@Column(name = "end_date")
    private Date end_date;

    //@Column(name = "rep_image")
    private String rep_image;
}
