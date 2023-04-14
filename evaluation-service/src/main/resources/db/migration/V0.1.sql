USE exam_service;

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
  PRIMARY KEY (id_option)
  );

CREATE TABLE Question (
  id_question BIGINT NOT NULL,
  question_description VARCHAR(1000) NOT NULL,
  assessment DOUBLE NOT NULL,
	question_type ENUM('ONLY_ANSWER', 'MULTI_ANSWER', 'OPEN_ANSWER') NOT NULL,
  open_answer VARCHAR(1000),
  exam BIGINT NOT NULL,
  id_option BIGINT NOT NULL,
  PRIMARY KEY (id_question),
  CONSTRAINT fk_Question_Option
    FOREIGN KEY (id_option)
    REFERENCES ExamOption (id_option)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE Exam (
  id_exam BIGINT NOT NULL,
  introduction VARCHAR(1000),
  max_score DOUBLE NOT NULL,
  exam_link VARCHAR(500) NOT NULL,
  question BIGINT NOT NULL,
  PRIMARY KEY (id_exam),
  CONSTRAINT fk_Exam_Question
    FOREIGN KEY (question)
    REFERENCES Question (id_question)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE Answer (
  id_answer BIGINT NOT NULL,
  open_answer VARCHAR(1000),
  assessment DOUBLE NOT NULL,
  id_option BIGINT NOT NULL,
  question BIGINT NOT NULL,
  PRIMARY KEY (id_answer),
  CONSTRAINT fk_Answer_Option
    FOREIGN KEY (id_option)
    REFERENCES ExamOption (id_option)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_Answer_Question
    FOREIGN KEY (question)
    REFERENCES Question (id_question)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE ExamPresentation (
  id_exam_presentation BIGINT NOT NULL,
  score DOUBLE NOT NULL,
  student BIGINT NOT NULL,
  exam BIGINT NOT NULL,
  answer BIGINT NOT NULL,
  PRIMARY KEY (id_exam_presentation),
  CONSTRAINT fk_ExamPresentation_Student
    FOREIGN KEY (student)
    REFERENCES Student (id_student)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT fk_ExamPresentation_Exam
    FOREIGN KEY (exam)
    REFERENCES Exam (id_exam)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_ExamPresentation_Answer
    FOREIGN KEY (answer)
    REFERENCES Answer (id_answer)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );