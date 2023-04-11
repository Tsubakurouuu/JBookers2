/*m_userマスタ*/
INSERT INTO m_user(
    name,
    email,
    password,
    introduction
)VALUES
('Tarou','torou@example.com','$2a$10$APeI3rBtAl558SHXVVjO9ef/Gu.5ojfFR7f.5p/h3qZ1STGAjHAXa','Hello'),
('Zirou','zirou@example.com','$2a$10$APeI3rBtAl558SHXVVjO9ef/Gu.5ojfFR7f.5p/h3qZ1STGAjHAXa','Hello');

/*bookマスタ*/
INSERT INTO book(
	user_id,
	title,
	body
) VALUES
	(1,'リーダブルコード','より良いコードを書くためのシンプルで実践的なテクニック'),
	(1,'トラブル知らずのシステム設計','システム設計の要点を図解で説明してくれます'),
	(1,'たのしいRuby','Rubyの入門におすすめです'),
	(1,'入門Git','gitについての基本操作から内部構造まで解説してくれます'),
	(2,'アルゴリズム図鑑','アルゴリズムについてカラーイラストでしっかり解説してくれます');