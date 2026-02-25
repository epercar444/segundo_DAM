# -*- mode: python ; coding: utf-8 -*-
block_cipher = None
a = Analysis(
 ['hola_mundo.py'],
 datas=[('iconos', 'iconos')],
 binaries=[],
 hiddenimports=[],
 hookspath=[],
 runtime_hooks=[],
 excludes=[],
 cipher=block_cipher,
)
pyz = PYZ(a.pure, a.zipped_data, cipher=block_cipher)
exe = EXE(
 pyz,
 a.scripts,
 [],
 name='hola-mundo',
 console=False
)
coll = COLLECT(
 exe,
 a.binaries,
 a.zipfiles,
 a.datas,
 name='hola-mundo'
)