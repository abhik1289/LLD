
//egar loading
// class JudgeAnalysis {

//     private static final JudgeAnalysis judgeAnalysis = new JudgeAnalysis();

//     private JudgeAnalysis() {
//     }

//     public static JudgeAnalysis getInstance() {
//         return judgeAnalysis;
//     }

// }

//lazy loading
//not thread safe
// class JudgeAnalysis {

//     private static JudgeAnalysis judgeAnalysis;

//     private JudgeAnalysis() {
//     }

//     public static JudgeAnalysis getInstance() {
//         if (judgeAnalysis == null) {
//             judgeAnalysis = new JudgeAnalysis();
//         }
//         return judgeAnalysis;
//     }

// }

// how to this thred safe
//1) use synchronized (not that much effcient)
// class JudgeAnalysis {

//     private static JudgeAnalysis judgeAnalysis;

//     private JudgeAnalysis() {
//     }

//     public static synchronized JudgeAnalysis getInstance() {
//         if (judgeAnalysis == null) {
//             judgeAnalysis = new JudgeAnalysis();
//         }
//         return judgeAnalysis;
//     }

// }

//way 2 using volatile
// class JudgeAnalysis {

//     private static volatile JudgeAnalysis judgeAnalysis;

//     private JudgeAnalysis() {
//     }

//     public static JudgeAnalysis getInstance() {
//         if (judgeAnalysis == null) {
//             synchronized (JudgeAnalysis.class) {
//                 if (judgeAnalysis == null) {
//                     judgeAnalysis = new JudgeAnalysis();
//                 }
//             }
//         }
//         return judgeAnalysis;
//     }

// }

class JudgeAnalysis {

    private JudgeAnalysis() {
    }

    private static class Holder {
        private static final JudgeAnalysis INSTANCE = new JudgeAnalysis();
    }

    public static JudgeAnalysis getInstance() {
        return Holder.INSTANCE;

    }

}

public class Main1 {
    public static void main(String[] args) {

        JudgeAnalysis j1 = JudgeAnalysis.getInstance();
        // it is intialize when we use it for the first time (lazy loading)
        JudgeAnalysis j2 = JudgeAnalysis.getInstance();

        System.out.println(j1 + " " + j2);

    }
}