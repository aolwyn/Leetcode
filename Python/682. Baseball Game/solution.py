class Solution:
    def calPoints(self, operations: List[str]) -> int:
        # makign the assumption that all ops are valid
        points = []

        for op in operations:
            if op == "+":
                points.append(points[-1] + points[-2])
            
            elif op == "D":
                
                points.append(points[-1] * 2)

            elif op == "C":
                
                points.pop()
            
            else:
                
                points.append(int(op))

        return sum(points)