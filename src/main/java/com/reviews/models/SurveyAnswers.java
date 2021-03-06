/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reviews.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author afrodeb
 */
@Entity
@Table(name = "survey_answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SurveyAnswers.findAll", query = "SELECT s FROM SurveyAnswers s")
    , @NamedQuery(name = "SurveyAnswers.findById", query = "SELECT s FROM SurveyAnswers s WHERE s.id = :id")
    , @NamedQuery(name = "SurveyAnswers.findBySurveyQuestionId", query = "SELECT s FROM SurveyAnswers s WHERE s.surveyQuestionId = :surveyQuestionId")
    , @NamedQuery(name = "SurveyAnswers.findByCreated", query = "SELECT s FROM SurveyAnswers s WHERE s.created = :created")})
public class SurveyAnswers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "survey_question_id")
    private int surveyQuestionId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "answer")
    private String answer;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public SurveyAnswers() {
    }

    public SurveyAnswers(Integer id) {
        this.id = id;
    }

    public SurveyAnswers(Integer id, int surveyQuestionId, String answer, Date created) {
        this.id = id;
        this.surveyQuestionId = surveyQuestionId;
        this.answer = answer;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSurveyQuestionId() {
        return surveyQuestionId;
    }

    public void setSurveyQuestionId(int surveyQuestionId) {
        this.surveyQuestionId = surveyQuestionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurveyAnswers)) {
            return false;
        }
        SurveyAnswers other = (SurveyAnswers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.reviews.models.SurveyAnswers[ id=" + id + " ]";
    }
    
}
