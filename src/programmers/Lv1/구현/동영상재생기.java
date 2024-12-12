package programmers.Lv1.구현;

// 동영상 재생기, Programmers(Level 1) - [PCCP 기출문제] 1번
public class 동영상재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        String[] time = pos.split(":");
        int mmPos = Integer.parseInt(time[0]);
        int ssPos = Integer.parseInt(time[1]);

        String[] op_startTime = op_start.split(":");
        String[] op_endTime = op_end.split(":");
        String[] video_lenTime = video_len.split(":");
        int op_startMM = Integer.parseInt(op_startTime[0]);
        int op_startSS = Integer.parseInt(op_startTime[1]);
        int op_startSum = op_startMM * 60 + op_startSS;

        int op_endMM = Integer.parseInt(op_endTime[0]);
        int op_endSS = Integer.parseInt(op_endTime[1]);
        int op_endSum = op_endMM * 60 + op_endSS;

        int video_lenMM = Integer.parseInt(video_lenTime[0]);
        int video_lenSS = Integer.parseInt(video_lenTime[1]);
        int video_lenSum = video_lenMM * 60 + video_lenSS;

        int nowPosSum = 0;

        for (String command : commands) {
            nowPosSum = mmPos * 60 + ssPos;
            if (nowPosSum >= op_startSum && nowPosSum <= op_endSum) {
                mmPos = op_endMM;
                ssPos = op_endSS;
            }

            if (command.equals("prev")) {
                if (mmPos == 0 && ssPos < 10) {
                    mmPos = 0;
                    ssPos = 0;
                } else if (ssPos < 10) {
                    mmPos -= 1;
                    ssPos = ssPos - 10 + 60;
                } else {
                    ssPos -= 10;
                }
            }

            if (command.equals("next")) {
                int posSum = mmPos * 60 + ssPos;
                if (video_lenSum - posSum < 10) {
                    mmPos = video_lenMM;
                    ssPos = video_lenSS;
                } else if (ssPos >= 50) {
                    mmPos += 1;
                    ssPos = ssPos + 10 - 60;
                } else {
                    ssPos += 10;
                }
            }

            nowPosSum = mmPos * 60 + ssPos;
            if (nowPosSum >= op_startSum && nowPosSum <= op_endSum) {
                mmPos = op_endMM;
                ssPos = op_endSS;
            }
        }

        String mm = "";
        String ss = "";

        if (mmPos <= 9) {
            mm = Integer.toString(mmPos);
            mm = "0" + mm;
        } else {
            mm = Integer.toString(mmPos);
        }

        if (ssPos <= 9) {
            ss = Integer.toString(ssPos);
            ss = "0" + ss;
        } else {
            ss = Integer.toString(ssPos);
        }

        answer = mm + ":" + ss;

        return answer;
    }
}
