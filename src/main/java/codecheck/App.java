package codecheck;

public class App {
	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {

			try {
				// 全角文字を含む場合はExceptionをスローして「invalid」を出力
				if (args[i].getBytes("Windows-31J").length != args[i].length()) {
					throw new Exception();
		        }

				// 引数をint型に変換
				int param = Integer.parseInt(args[i]);

				if (param < 0 || param > 1000) {
					// 負整数または1000より大きい非負整数の場合は「invalid」を出力
					System.out.println("invalid");
				} else {

					// 引数が3で割り切れるか
					int mod3 = param % 3;
					boolean idiot = false;
					if (mod3 == 0) {
						idiot = true;
					}
					// 引数に3が含まれるか
					boolean stupid = false;
					if (args[i].contains("3")) {
						stupid = true;
					}

					if (idiot && stupid) {
						// 3の倍数でかつ3のつく1000以下の非負整数
						System.out.println("dumb");
					} else if(idiot) {
						// 3の倍数の1000以下の非負整数
						System.out.println("idiot");
					} else if(stupid) {
						// 3のつく1000以下の非負整数の場合
						System.out.println("stupid");
					} else {
						// それ以外の1000以下の非負整数
						System.out.println("smart");
					}
				}
			} catch(NumberFormatException e) {
				// NumberFormatException発生時は「invalid」を出力
				System.out.println("invalid");
			} catch(Exception e) {
				// 全角文字が含まれていた場合は「invalid」を出力
				System.out.println("invalid");
			}

		}
	}
}
