const spawn = require('child_process').spawn;

function exec(cmd, args, cwd) {
  return new Promise((f, r) => {

    const ex = spawn(cmd, args, {cwd});

    ex.stdout.on('data', (data) => {
      console.log(`stdout: ${data}`);
    });

    ex.stderr.on('data', (data) => {
      console.log(`stderr: ${data}`);
    });

    ex.on('close', (code) => {
      console.log(`child process exited with code ${code}`);
      if (code != 0) {
        r(code);
      } else {
        f();
      }
    });

  });  
}


function buildUI() {
  return exec('npm.cmd', ['run', 'build'], './ui');
}

function buildWar() {
  return exec('mvn.cmd', ['clean', 'install'], './CRF');
}

(async function build() {

  // build ui
  await buildUI()

  // buid war
  await buildWar()


})().catch(err => {
  console.error('faild to build war:', err)
})