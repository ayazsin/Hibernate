package project03_oneToMany.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "QUESTION",
        uniqueConstraints={
                @UniqueConstraint(columnNames={"Q_NAME"})
        })
public class Question implements Serializable {

    private static final long serialVersionUID = -578848996893330737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Q_NAME", nullable = false, length=100)
    private String qName;

    @OneToMany(targetEntity=Answer.class, cascade = {CascadeType.ALL})
    @JoinColumn(name="q_id", nullable=false)
    private List<Answer> answers;

    public Question() {
        super();
    }

    public Question(String qName, Answer[] answers) {
        super();
        this.qName = qName;
        this.answers = Arrays.asList(answers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", qName=" + qName + ", answers=" + answers + "]";
    }

}
