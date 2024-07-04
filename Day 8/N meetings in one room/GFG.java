//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static class Pair{
        int start;
        int end;
        Pair(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Pair> list = new ArrayList<>();
        for(int i =0;i<n;i++)list.add(new Pair(start[i],end[i]));
        
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.start != p2.start) {
                    return p1.start - p2.start;
                } else {
                    return p1.end - p2.end;
                }
            }
        });


        int s = list.get(0).start, e = list.get(0).end;
        int count = 1;
        for (int i = 1; i < n; i++) {
            int c = list.get(i).start;
            int d = list.get(i).end;
            // agar s-------------c-----d-----------e is type ka ho 
            if((s<= c && e>c) && (s<=d && e>d)){
                s = c;
                e = d;
            }
            // agar s---e--c--d is type ka ho 
            else if((s<c&&e<c)&&(s<d&&e<d)){
                s = c;
                e = d;
                count++;
            }
        }

        return count;
        
        
    }
}
