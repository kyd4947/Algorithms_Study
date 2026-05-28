package Algorithms_Study;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_21610 {
	// 8 방향 처리		   ←  ↖   ↑   ↗   →  ↘  ↓  ↙
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	// 대각선만 처리 (물 복사)
	static int[] diagR = {-1, -1, 1, 1};
	static int[] diagC = {-1, 1, -1, 1};
	
	// 매개 변수
	static int n, m;
	
	// 지도
	static int[][] map;
	
	// 방문 처리
	static boolean[][] visited;
	
	// 구름 큐 생성
	static ArrayDeque<Cloud> clouds = new ArrayDeque<>();
	
	// 구름 객체 생성
	static class Cloud{
		int r, c;
		
		public Cloud(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	// 구름 이동 함수
	static void moveCloud(int d, int s) {
		for(Cloud cloud : clouds) {
			// 이동 위치 계산
			int nr = (cloud.r + dr[d] * (s % n) + n) % n;
			int nc = (cloud.c + dc[d] * (s % n) + n) % n;
			
			cloud.r = nr;
			cloud.c = nc;
		}
	}
	
	// 비 내리기 함수
	static void rain() {
		for(Cloud cloud : clouds) {
			map[cloud.r][cloud.c]++;
			// 방문 처리
			visited[cloud.r][cloud.c] = true;
		}
	}
	
	// 물 복사
	static void waterCopy() {
		for(Cloud cloud : clouds) {
			int cnt = 0;
			for(int i = 0; i < 4; i++) {
				int nr = cloud.r + diagR[i];
				int nc = cloud.c + diagC[i];
				
				// 맵 안 & 대각선 칸 물 존재 시
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					if(map[nr][nc] > 0) {
						cnt++;	
					}
				}
			}
			map[cloud.r][cloud.c] += cnt;
		}
	}
	
	// 구름 새로 생성
	static void makeCloud() {
		// 구름 제거
		clouds.clear();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] >= 2 && !visited[r][c]) {
					clouds.add(new Cloud(r, c));
					
					map[r][c] -= 2;
				}
				visited[r][c] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 입력 처리
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 구름 초기 위치
		clouds.add(new Cloud(n - 1, 0));
		clouds.add(new Cloud(n - 1, 1));
		clouds.add(new Cloud(n - 2, 0));
		clouds.add(new Cloud(n - 2, 1));
		
		visited = new boolean[n][n];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			moveCloud(d, s);
			rain();
			waterCopy();
			makeCloud();
			}
		
		// 물 양의 합
		int sum = 0;
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				sum += map[r][c];
			}
		}
		
		System.out.println(sum);
	}
}