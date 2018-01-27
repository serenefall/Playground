n=10;
v = 1:n;

sum_v = 0;
for i = 1:length(v)
    sum_v = sum_v + v(i);
end

sum_v
%%
Five5 = zeros(floor(637/5) - floor(34/5), 1);

count = 0;

for i = 7:637/5
    if 5*i > 34 & 5*i < 637
            Five5(i-6) = [5*i];
    end
end

Five5

l = length(Five5);

l

Ten10 = [Five5:10:635]'


%%
F = zeros(ceil(637/5) - ceil(36/5), 1);
F;
length(F)

%%



x = [0:360];
y1 = sin(x*pi/180);
y2 = cos(x*pi/180);
y3 = tan(x*pi/180);

subplot(2,2,1);
plot(x, y1);
subplot(2,2,2);
plot(x, y2);
subplot(2,2,3);
plot(x, y3);


%%
ax1 = subplot(2,1,1)
x = 0:360;
plot (x, sin(x*pi/180), x, cos(x*pi/180));








%%
























