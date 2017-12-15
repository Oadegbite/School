defmodule Output do
  defp abc (x) do
    cond do
      x > 0 -> 1
      x < 0 -> -1
      true -> 0
    end
end
defp fgh(x,y), do: x*y
defp n(x,x), do: []
defp n(x,y), do: [y|n(x,y+1)]
defp n(x), do: n(x,-x)
def ghi() do
  for x < -1..4 , y<-n(4), y<3 , x>1 , do: x+y
end
def hij() do
  ghi() |>
    Enum.take(7) |>
    Enum.map(fn x -> fgh(abc(x),x)end)
  end
end
[x1,x2,x3|x4]=Output.ghi()
[y1,y2,y3|y4]=Output.hij()
