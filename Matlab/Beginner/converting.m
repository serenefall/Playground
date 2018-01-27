function c = converting(x)
    N = length(x);
    y = zeros(1,N);
    for i = 1:N
        if x(i) < 0
            y(i) = 0;
        else
            y(i) = 5;
        end
    end
    
    c = y;
end