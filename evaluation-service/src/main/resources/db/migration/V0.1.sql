CREATE TABLE Student (
  id_student BIGINT NOT NULL,
  id_card VARCHAR(45) NOT NULL,
  student_name VARCHAR(100),
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_student)
  );

CREATE TABLE ExamOption (
  id_option BIGINT NOT NULL,
  option_description VARCHAR(1000) NOT NULL,
  is_correct BOOLEAN NOT NULL,
  question BIGINT NOT NULL,
  answer BIGINT NOT NULL,
  PRIMARY KEY (id_option, question, answer)
  );

CREATE TABLE Question (
  id_question BIGINT NOT NULL,
  question_description VARCHAR(1000) NOT NULL,
  assessment DOUBLE NOT NULL,
	question_type ENUM('ONLY_ANSWER', 'MULTI_ANSWER', 'OPEN_ANSWER') NOT NULL,
  open_answer VARCHAR(1000),
  exam BIGINT NOT NULL,
  Option_id_option BIGINT NOT NULL,
  Option_question BIGINT NOT NULL,
  PRIMARY KEY (id_question, exam, Option_id_option, Option_question),
  CONSTRAINT fk_Question_Option1
    FOREIGN KEY (Option_id_option , Option_question)
    REFERENCES ExamOption (id_option , question)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE Exam (
  id_exam BIGINT NOT NULL,
  introduction VARCHAR(1000),
  max_score DOUBLE NOT NULL,
  exam_link VARCHAR(500) NOT NULL,
  Question_id_question BIGINT NOT NULL,
  Question_exam BIGINT NOT NULL,
  PRIMARY KEY (id_exam, Question_id_question, Question_exam),
  CONSTRAINT fk_Exam_Question1
    FOREIGN KEY (Question_id_question , Question_exam)
    REFERENCES Question (id_question , exam)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE Answer (
  id_answer BIGINT NOT NULL,
  open_answer VARCHAR(1000),
  assessment DOUBLE NOT NULL,
  Option_id_option BIGINT NOT NULL,
  Question_id_question BIGINT NOT NULL,
  PRIMARY KEY (id_answer, Option_id_option, Question_id_question),
  CONSTRAINT fk_Answer_Option1
    FOREIGN KEY (Option_id_option)
    REFERENCES ExamOption (id_option)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Answer_Question1
    FOREIGN KEY (Question_id_question)
    REFERENCES Question (id_question)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE ExamPresentation (
  id_exam_presentation BIGINT NOT NULL,
  score DOUBLE NOT NULL,
  Student_id_student BIGINT NOT NULL,
  Exam_id_exam BIGINT NOT NULL,
  Answer_id_answer BIGINT NOT NULL,
  PRIMARY KEY (id_exam_presentation, Student_id_student, Exam_id_exam, Answer_id_answer),
  CONSTRAINT fk_ExamPresentation_Student
    FOREIGN KEY (Student_id_student)
    REFERENCES Student (id_student)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT fk_ExamPresentation_Exam1
    FOREIGN KEY (Exam_id_exam)
    REFERENCES Exam (id_exam)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_ExamPresentation_Answer1
    FOREIGN KEY (Answer_id_answer)
    REFERENCES Answer (id_answer)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );