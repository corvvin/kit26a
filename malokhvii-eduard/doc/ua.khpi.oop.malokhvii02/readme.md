# �2 ����: ��������� �������� ��� ��������� Java SE. ����� ��������� ������� �����.<br/>����: �������� ������� ���������� ������� ��� ��������� Java SE. 

# 1 ������������ ��������

## 1.1 ���������

������� ������� ������ ����������, ʲ�-26�, ������ 8 (�������� �6).

## 1.2 ������

1. ��������� �� ���������������� �������� ����� Java � ���������� Eclipse ��� �������� ��������� ������ �� �������, �� ������� ���������� �� ������� ������� �� ������ �� 10 ���������� �� ������� ������ �������� � ������ �����.
2. ��� ���������� ������� ����� ��������������� ��������� ���������������� ����� (java.util.Random) �� ����������� ������� (��������� ������ ��������) ����������� ���������� ������ ��������� ������.
3. ����������� ��������� �� ������ ��������� ������� ������� ����� �� ���������� ��������� � ������ �������.
4.������������� ������������ ����� ���� String �� ������ ��� ����������� ������ ��������� ������.
5.����������� ������������� (����������) ������������ � ����������� ������ ��������� ������ �� ��������� ��������� ��������� ������.

## 1.3 ��������

��������� �� ������� ���� ������ ����� ���� ��� �������� ����� ���� � ����������� ������ 6-�������� ������ �����.

# 2 �������� ��������

## 2.1 ������ ��� 

ϳ� ��� �������� ����������� ������ ���� ����������� ����� �� ������������ ������� ������� �� ��������� ������� �����. ����� ��'��� ����� ���� �������� ��������� ����� ���� ��������� ��������� ��������� ��� ������� ������ ������ (���������, �������, �����������). ��'��� ����� ���� ��������� ������������ ���� �� ��� ��������� ��������, �� ���������� ������� ���� ��������� �����.

<center>
  <img src="http://i.piccy.info/i9/1ae875572b38279b8016b4ddac677f78/1505476409/63809/1179545/events.png" alt="ĳ������ �����䳿 ����">
  <p>���. 1 - ĳ������� �����䳿 ����</p>
</center>

## 2.2 �������� �� ��������� �����

������ ������ �������� ������:
- data - ������ � ��� ��������� ����� ������� �����
- event - ������ � ��� ��������� ����� ������� ����, �� ���������� �� ��������.

����� �������� ������� ����� �������� �� ��������� ���������� ��� ������ �������� Eclipse - ObjectAid UML Diagram.

<center>
  <img src="http://i.piccy.info/i9/e34063b24a906b44e74ac2b825e1beed/1505474237/30635/1179545/ua_khpi_oop_malokhvii02_data.png" alt="ĳ������ ����� �� ������ data">
  <p>���. 2 - ĳ������� ����� �� ������ data</p>
</center>

<center>
  <img src="http://i.piccy.info/i9/193d4c3db1e6cc3115e05fdea3e00d14/1505474472/74507/1179545/ua_khpi_oop_malokhvii02_event.png" alt="ĳ������ ����� �� ������ event">
  <p>���. 3 - ĳ������� ����� �� ������ event</p>
</center>

<center>
  <img src="http://i.piccy.info/i9/270c1d081011e0d5e14b802a00433b1d/1505474597/116781/1179545/ua_khpi_oop_malokhvii02.png" alt="ĳ������ ����� �� ������ event">
  <p>���. 4 - �������� ������� �����</p>
</center>

## 2.3 ���� ��������

�� ������ ����������� ������ ���� �������� �������� �������� �� ��� ���������� � ������ �������, ������ �������� ����������� �� ��������� ����� java.util.Random. ��� ������������ ��������� ���� ����������� format �� printf.

## 2.4 ������ ��������� ��������

����� �������� �������� ��������� �������� ��� ���������� �������. ���� ��������� ���������� ��� �� ���������� (<https://sourceforge.net/p/kit26a-cpp/code/HEAD/tree/malokhvii_eduard/src/ua/khpi/oop/malokhvii02/>).

```
package ua.khpi.oop.malokhvii02;

import java.util.Scanner;

import ua.khpi.oop.malokhvii02.data.DataContainer;
import ua.khpi.oop.malokhvii02.data.NumberEqualityContainer;
import ua.khpi.oop.malokhvii02.event.EventLoop;
import ua.khpi.oop.malokhvii02.event.EventsContainer;
import ua.khpi.oop.malokhvii02.event.GlobalEventsContainer;

public final class Application {

    private Application() {

    }

    public static void main(final String[] args) {
        DataContainer dataContainer = new NumberEqualityContainer();
        EventsContainer loopEvents = GlobalEventsContainer.getInstance();
        EventLoop eventLoop = new EventLoop(dataContainer, loopEvents,
                System.out, new Scanner(System.in));

        eventLoop.launchLoop();
        while (eventLoop.isRunning()) {
            eventLoop.handleCurrentEvent();
        }
        eventLoop.closeStream();
    }
}
```

# 3 ���������� ������

����� �������� ��������� ��������� � ������ ������� �� ������������ ������.

<center>
  <img src="http://i.piccy.info/i9/8c53a3c96b4154d4a3d7da548a371f2e/1505480696/52033/1179545/application_1.png" alt="��������� ���������">
  <p>���. 5 - ��������� ���������</p>
</center>

<center>
  <img src="http://i.piccy.info/i9/ebca129477b1955f8df721fec2aa48cf/1505480812/41648/1179545/application_2.png" alt="��������� ���������">
  <p>���. 6 - ��������� ���������</p>
</center>

# ��������

� ��� ��������� ����������� ������ ���� ��������� ������� �����䳿 � ��������� ��������� �� ��������, ����������. ��������� ����� ������ java.util.