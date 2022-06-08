package array;

public class HomeworkScore {
	int[] studentScore;
	int index;
	int max;
	int min;
	int num;
	double sum;
	double avg;
	
	// 생성자
	HomeworkScore() {
		index = -1;
	}
	
	// 메소드
	// 1. 학생수 입력
	void studentNum(int studentNum) {
		studentScore = new int[studentNum];
	}
	
	// 2. 학생 점수 등록
	void studentScore(int score) {
		studentScore[++index] = score;
	}
	
	// 3. 학생점수 전체 조회
	void printScore() {
		for(int i = 0; i < index+1; i++) {
			System.out.println("점수 : " + studentScore[i]);
		}
	}
	
	// 4. 학생정보 분석
	// 최고점
	int maxScore() {
		for(int i = 0; i < index+1; i++) {
			if (max < studentScore[i]) {
				max = studentScore[i];
			}
		}
		System.out.println(max);
		return max;
	}
	
	// 최저점
	int minScore() {
		min = studentScore[0];
		for (int i = 0; i < index+1; i++) {
			if (min > studentScore[i]) {
				min = studentScore[i];
			}
		}
		System.out.println(min);
		return min;
	}
	
	// 최고점, 최대점 제외 평균점수
	void avgScore() {
		for (int i = 0; i < index+1; i++) {
			sum += studentScore[i];
		}
		avg = (sum - max - min) / (index-1);
		System.out.printf("%.2f \n", avg);
	}
	
	// 분석기능
	void analyze() {
		maxScore();
		minScore();
		avgScore();
	}
	}


