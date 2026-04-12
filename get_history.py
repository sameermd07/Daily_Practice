import sqlite3
import os
import shutil

p = os.path.expanduser('~\\AppData\\Local\\Microsoft\\Edge\\User Data\\Default\\History')
temp_p = p + '_temp'
try:
    if os.path.exists(p):
        shutil.copy2(p, temp_p)
        conn = sqlite3.connect(temp_p)
        c = conn.cursor()
        c.execute("SELECT url, title FROM urls WHERE title LIKE '%LeetCode%' ORDER BY last_visit_time DESC LIMIT 200")
        rows = c.fetchall()
        for r in rows:
            if '1974630667' in r[0] or '1974568851' in r[0] or '1974683025' in r[0]:
                print(f'MATCH: {r}')
            else:
                pass
        conn.close()
except Exception as e:
    print(e)

p2 = os.path.expanduser('~\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\History')
temp_p2 = p2 + '_temp'
try:
    if os.path.exists(p2):
        shutil.copy2(p2, temp_p2)
        conn = sqlite3.connect(temp_p2)
        c = conn.cursor()
        c.execute("SELECT url, title FROM urls WHERE title LIKE '%LeetCode%' ORDER BY last_visit_time DESC LIMIT 200")
        rows = c.fetchall()
        for r in rows:
            if '1974630667' in r[0] or '1974568851' in r[0] or '1974683025' in r[0]:
                print(f'CHROME MATCH: {r}')
        conn.close()
except Exception as e:
    print(e)

